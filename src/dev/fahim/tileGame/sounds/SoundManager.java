package dev.fahim.tileGame.sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {

	//Files
	File battleMusic,menuMusic;
	File swordHit,die,fireball,fireballImpact,arrowImpact,arrowShot;
	
	//Audio streams
	AudioInputStream battleMusicStream,menuMusicStream;
	AudioInputStream swordHitStream,dieStream, fireballStream,fireballImpactStream,arrowImpactStream,arrowShotStream;
	
	//Clips
	public Clip battleMusicClip,menuMusicClip;
	public Clip BGMusic;
	public Clip swordHitClip,dieClip, fireballClip,fireballImpactClip,arrowImpactClip,arrowShotClip;
		
	public SoundManager()
	{
	
	try
	{
	
	battleMusic = new File("F:/Eclipse workspace/TileGame/res/Sounds/lastBattle.wav");
	menuMusic = new File("F:/Eclipse workspace/TileGame/res/Sounds/menuMusic.wav");
	swordHit = new File("F:/Eclipse workspace/TileGame/res/Sounds/swordHit.wav");
	die = new File("F:/Eclipse workspace/TileGame/res/Sounds/die.wav");
	fireball = new File("F:/Eclipse workspace/TileGame/res/Sounds/fireball.wav");
	fireballImpact = new File("F:/Eclipse workspace/TileGame/res/Sounds/fireballImpact.wav");
	arrowImpact = new File("F:/Eclipse workspace/TileGame/res/Sounds/arrowImpact.wav");
	arrowShot = new File("F:/Eclipse workspace/TileGame/res/Sounds/arrowShot.wav");
	
	battleMusicStream = AudioSystem.getAudioInputStream(battleMusic);
	menuMusicStream = AudioSystem.getAudioInputStream(menuMusic);
	swordHitStream = AudioSystem.getAudioInputStream(swordHit);
	dieStream = AudioSystem.getAudioInputStream(die);
	fireballStream = AudioSystem.getAudioInputStream(fireball);
	fireballImpactStream = AudioSystem.getAudioInputStream(fireballImpact);
	arrowImpactStream = AudioSystem.getAudioInputStream(arrowImpact);
	arrowShotStream = AudioSystem.getAudioInputStream(arrowShot);
	
	battleMusicClip = AudioSystem.getClip();
	battleMusicClip.open(battleMusicStream);
	menuMusicClip = AudioSystem.getClip();
	menuMusicClip.open(menuMusicStream);
	swordHitClip = AudioSystem.getClip();
	swordHitClip.open(swordHitStream);
	dieClip = AudioSystem.getClip();
	dieClip.open(dieStream);
	fireballClip = AudioSystem.getClip();
	fireballClip.open(fireballStream);
	fireballImpactClip = AudioSystem.getClip();
	fireballImpactClip.open(fireballImpactStream);
	arrowImpactClip = AudioSystem.getClip();
	arrowImpactClip.open(arrowImpactStream);
	arrowShotClip = AudioSystem.getClip();
	arrowShotClip.open(arrowShotStream);
	
	BGMusic = menuMusicClip;
	
	} catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
     } catch (IOException e) {
        e.printStackTrace();
     } catch (LineUnavailableException e) {
        e.printStackTrace();
     }
	
	BGMusic.loop(Clip.LOOP_CONTINUOUSLY);
	
	}
	
	public void tick()
	{

	}
	
	public void play(Clip c)
	{
		if(c.isRunning()){return;}
		//System.out.println("blah");
		c.setFramePosition(0);
		c.start();
	}
	
}
