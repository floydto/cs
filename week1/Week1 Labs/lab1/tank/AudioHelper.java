/*
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * AudioHelper plays sampled audio clips and midi sequences.
 * Clips and midis must be loaded into this audio player before first playback.
 * <p>
 * AudioHelper can be used also inside applets and BlueJ IDE.<br>
 * Compatible with JRE 1.3 and later versions.
 * <p>
 * Supported sampled formats: WAV, AU, SND, AIFF and AIFC<br>
 * Supported midi formats: MIDI 1.0
 */
public class AudioHelper {
	private static Map clips; // holds list of available sampled clips
	private static Map midis; // holds list of available midi songs
	private static Object activeSeq; // key of playing sequence
	private static Sequencer sequencer; // midi sequencer
	private static Object obj; // aux object for resource loading

	/*
	 * Class can not be instantiated from outside.
	 */
	private AudioHelper() {
	}

	/*
	 * Static initializer.
	 */
	static {
		clips = Collections.synchronizedMap(new HashMap());
		midis = Collections.synchronizedMap(new HashMap());
		obj = new AudioHelper();
	}

	/**
	 * Loads audio clip from resource pathname into the AudioHelper.
	 * 
	 * Resources are part of application (stored in project folder or 
	 * packed into single jar together with class files).
	 * <p>
	 * The resource name is platform independent pathname separated by '/'.
	 * The resource is looked up by corresponding classloader.<br>
	 * Relative resource pathnames are resolved against this class, it means that package
	 * name of this class is prepended and '.' is replaced by '/'.<br>
	 * Absolute resource pathnames start with '/' - denoting root of corresponding package hierarchy.
	 *
	 * @param key  key associated with the clip.
		 * @param name  resource pathname to load clip from; absolute or relative.
	 * @return  true if loaded, false otherwise.
	 */
	public static boolean loadClipResource(Object key, String name) {
		URL url;
		try {
			url = obj.getClass().getResource(name);
		} catch (Exception ex) {
			System.err.println(
				"Clip resource " + name + " can not be found. (Exception: " + ex + ")");
			return false;
		}
		return loadClip(key, url);
	}

	/**
	 * Loads arbitrary audio clip into the AudioHelper.
	 * 
	 * If a sound with this key already exists, the old sound is replaced.
	 *
	 * @param key  key associated with the clip.
	 * @param url  URL to load clip from.
	 * @return  true if loaded, false otherwise.
	 */
	public static boolean loadClip(Object key, URL url) {
		Clip clip;
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(url);
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
		} catch (Exception ex) {
			System.out.println(
				"Clip " + url.getPath() + " can not be loaded. (Exception: " + ex + ")");
			return false;
		}
		synchronized (clips) {
			if (clips.containsKey(key)) {
				Clip old = (Clip) clips.get(key);
				old.stop();
				old.close();
			}
			clips.put(key, clip);
		}
		return true;
	}

	/**
	 * Loads midi sequence from resource pathname into the AudioHelper.
	 * 
	 * Resources are part of application (stored in project folder or 
	 * packed into single jar together with class files).
	 * <p>
	 * The resource name is platform independent pathname separated by '/'.
	 * The resource is looked up by corresponding classloader.<br>
	 * Relative resource pathnames are resolved against this class, it means that package
	 * name of this class is prepended and '.' is replaced by '/'.<br>
	 * Absolute resource pathnames start with '/' - denoting root of corresponding package hierarchy.
	 *
	 * @param key  key associated with the midi.
	 * @param name  resource pathname to load midi from; absolute or relative.
	 * @return  true if loaded, false otherwise.
	 */
	public static boolean loadMidiResource(Object key, String name) {
		URL url;
		try {
			url = obj.getClass().getResource(name);
		} catch (Exception e) {
			System.err.println("Midi resource " + name + " can not be found.");
			return false;
		}
		return loadMidi(key, url);
	}

	/**
	 * Loads arbitrary midi sequence into the AudioHelper.
	 * 
	 * If a midi with this key already exists, the old midi is replaced.
	 *
	 * @param key  key associated with the midi.
	 * @param url  URL to load midi from.
	 * @return  true if loaded, false otherwise.
	 */
	public static boolean loadMidi(Object key, URL url) {
		Sequence seq;
		try {
			seq = MidiSystem.getSequence(url);
		} catch (Exception ex) {
			System.out.println(
				"Midi " + url.getPath() + " can not be loaded. (Exception: " + ex + ")");
			ex.printStackTrace();
			return false;
		}
		synchronized (midis) {
			if (key.equals(activeSeq)) {
				if (sequencer != null) {
					sequencer.stop();
				}
			}
			midis.put(key, seq);
		}
		return true;
	}

	/**
	 * Plays sampled audio clip.
	 *
	 * @param key  key associated with the clip.
	 * @param looping  repeated clip playback.
	 */
	public static void playClip(Object key, boolean looping) {
		Clip clip = (Clip) clips.get(key);
		if (clip != null) {
			if (looping) {
				clip.setFramePosition(0);
				clip.setLoopPoints(0, clip.getFrameLength() - 1);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				clip.setFramePosition(0);
				clip.start();
			}
		}
	}

	/**
	 * Starts playback of midi sequence, currently playing midi is stopped.
	 *
	 * @param key  key associated with the midi.
	 */
	public static void playMidi(Object key) {
		Sequence seq = (Sequence) midis.get(key);
		if (seq != null) {
			if (sequencer == null) {
				try {
					sequencer = MidiSystem.getSequencer();
					sequencer.open();
				} catch (Exception ex) {
					ex.printStackTrace();
					sequencer = null;
					return;
				}
			} else {
				stopMidi();
			}
			try {
				activeSeq = key;
				sequencer.setSequence(seq);
				sequencer.start();
			} catch (Exception ex) {
				ex.printStackTrace();
				return;
			}
		}
	}

	/**
	 * Stops playback of the specified audio clip.
	 *
	 * @param key  key associated with the clip.
	 */
	public static void stopClip(Object key) {
		Clip clip = (Clip) clips.get(key);
		if (clip != null) {
			clip.stop();
		}
	}

	/**
	 * Stops playback of active midi sequence.
	 */
	public static void stopMidi() {
		if (sequencer != null) {
			sequencer.stop();
			activeSeq = null;
		}
	}

	/**
	 * Stops playback of all audio clips and active midi sequence.
	 */
	public static void stopAll() {
		stopMidi();
		synchronized (clips) {
			Iterator it = clips.values().iterator();
			while (it.hasNext()) {
				Clip clip = (Clip) it.next();
				clip.stop();
			}
		}
	}

	/**
	 * Stops playback and unloads all clips and midis.
	 */
	public static void clear() {
		synchronized (clips) {
			Iterator it = clips.values().iterator();
			while (it.hasNext()) {
				Clip clip = (Clip) it.next();
				clip.stop();
				clip.close();
			}
			clips.clear();
		}
		synchronized (midis) {
			stopMidi();
			midis.clear();
		}
	}

}
