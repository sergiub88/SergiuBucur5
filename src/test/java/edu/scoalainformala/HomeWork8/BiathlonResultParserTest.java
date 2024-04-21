package edu.scoalainformala.HomeWork8;

import edu.scoalainformala.HomeWork8.Athlete;
import edu.scoalainformala.HomeWork8.BiathlonResultParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiathlonResultParserTest {

    @Test
    public void testParseResults() {
        List<String> csvLines = Arrays.asList(
                "1;Jimmy Smiles;UK;29:15;xxoox;xooxo;xxxxo",
                "11;Umar Jorgson;SK;30:27;xxxox;xxxxx;xxoxo",
                "27;Piotr Smitzer;CZ;30:10;xxxxx;xxxxx;xxxxx"
        );

        List<Athlete> athletes = BiathlonResultParser.parseResults(csvLines);

        assertEquals(3, athletes.size(), "Should parse three athletes.");
        assertEquals(60, athletes.get(0).getTotalPenaltySeconds(), "Jimmy Smiles should have 60 seconds of penalties.");
        assertEquals(30, athletes.get(1).getTotalPenaltySeconds(), "Umar Jorgson should have 30 seconds of penalties.");
        assertEquals(0, athletes.get(2).getTotalPenaltySeconds(), "Piotr Smitzer should have no penalties.");
    }
}