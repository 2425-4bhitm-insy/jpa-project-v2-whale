INSERT INTO ConservationStatus (status_name) VALUES ('Endangered');
INSERT INTO ConservationStatus (status_name) VALUES ('Vulnerable');
INSERT INTO ConservationStatus (status_name) VALUES ('Least Concern');

INSERT INTO Diet (diet_name) VALUES ('Krill');
INSERT INTO Diet (diet_name) VALUES ('Fish');
INSERT INTO Diet (diet_name) VALUES ('Plankton');

INSERT INTO Ocean (ocean_name) VALUES ('Pacific');
INSERT INTO Ocean (ocean_name) VALUES ('Atlantic');
INSERT INTO Ocean (ocean_name) VALUES ('Indian');

INSERT INTO ResearchStation (lat, lon, ocean, DTYPE, city, country, researchStationName)
VALUES (34.05, -118.25, 1, 'Station', 'Los Angeles', 'USA', 'Pacific Research Center');

INSERT INTO ResearchStation (lat, lon, ocean, DTYPE, city, country, researchStationName)
VALUES (51.51, -0.13, 2, 'Station', 'London', 'UK', 'Atlantic Whale Base');

INSERT INTO WhaleSpecies (speciesName) VALUES ('Blue Whale');
INSERT INTO WhaleSpecies (speciesName) VALUES ('Humpback Whale');
INSERT INTO WhaleSpecies (speciesName) VALUES ('Orca');

INSERT INTO Whale (conservation_status_id, diet_id, whale_species_id, whaleName)
VALUES (1, 1, 1, 'Big Blue');

INSERT INTO Whale (conservation_status_id, diet_id, whale_species_id, whaleName)
VALUES (2, 2, 2, 'Humpy');

INSERT INTO WhaleTrackerHistory (lat, lon, ocean_id, timestamp, whale_id)
VALUES (33.9, -118.4, 1, CURRENT_TIMESTAMP, 1);

INSERT INTO WhaleTrackerHistory (lat, lon, ocean_id, timestamp, whale_id)
VALUES (52.5, -1.9, 2, CURRENT_TIMESTAMP, 2);
