package org.dev.warped.smarttv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andreas Wiedmer on 25.07.2016.
 */
public class RegExParserTest {
    @Test
    public void getIMDbRating() throws Exception {
        assertEquals(null, RegExParser.getIMDbRating(null, null));
        assertEquals("", RegExParser.getIMDbRating(null, ""));
        assertEquals("", RegExParser.getIMDbRating("", ""));
        assertEquals("IMDb", RegExParser.getIMDbRating(null, "IMDb"));
        assertEquals("IMDb", RegExParser.getIMDbRating("", "IMDb"));
        assertEquals("IMDb: 1", RegExParser.getIMDbRating("imdb 1", "IMDb"));
        assertEquals("IMDb: 2.0", RegExParser.getIMDbRating("imdb 2.0", "IMDb"));
        assertEquals("IMDb: 3.3", RegExParser.getIMDbRating("imdb rating: 3.3/10", "IMDb"));
        assertEquals("IMDb: 42", RegExParser.getIMDbRating("Movie FourtyTwo is the answer to everything, IMDb: 42", "IMDb"));
        assertEquals("IMDb: 6.9", RegExParser.getIMDbRating("Movie SixtyNine IMDb: 6.9, kinky.", "IMDb"));
    }
}
