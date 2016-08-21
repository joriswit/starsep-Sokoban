package com.starsep.sokoban.sokoban;

import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Log.class)
public class TileTest {
	@Test
	public void crateIsCrate() {
		assertTrue(Tile.isCrate(Tile.crate));
	}

	@Test
	public void crateIsNotMovable() {
		assertFalse(Tile.isMovable(Tile.crate));
	}

	@Test
	public void groundAndGrassIsMovable() {
		assertTrue(Tile.isMovable(Tile.ground));
		assertTrue(Tile.isMovable(Tile.grass));
	}

	@Test
	public void maskToMaskToCharIsIdentity() {
		char[] tiles = {
				Tile.crate, Tile.grass, Tile.ground, Tile.endpoint, Tile.crateOnEndpoint, Tile.wall};
		for (char tile : tiles) {
			assertEquals(Tile.maskToChar(Tile.mask(tile)), tile);
		}
	}

	@Test
	public void defaultMaskMovable() {
		PowerMockito.mockStatic(Log.class);
		assertEquals(Tile.mask('~'), Tile.MOVABLE);
		PowerMockito.verifyStatic();
	}

	@Test
	public void defaultMaskToCharGrass() {
		PowerMockito.mockStatic(Log.class);
		assertEquals(Tile.maskToChar(1337), Tile.grass);
		PowerMockito.verifyStatic();
	}

	@Test
	public void createTile() {
		try {
			Tile tile = new Tile();
		} catch (Throwable t) {
			assertTrue(false);
		}
	}

}
