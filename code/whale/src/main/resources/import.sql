INSERT INTO ConservationStatus (status_name)
VALUES
    ('Endangered'),
    ('Vulnerable'),
    ('Least Concern');

INSERT INTO Diet (diet_name)
VALUES
    ('Krill'),
    ('Fish'),
    ('Plankton');

INSERT INTO Ocean (ocean_name)
VALUES
    ('Pacific'),
    ('Atlantic'),
    ('Indian');

INSERT INTO ResearchStation (lat, lon, ocean, station_type, city, country, researchStationName)
VALUES
    (34.05, -118.25, 1, 'Station', 'Los Angeles', 'USA', 'Pacific Research Center'),
    (51.51, -0.13, 2, 'Station', 'London', 'UK', 'Atlantic Whale Base');

INSERT INTO WhaleSpecies (speciesName)
VALUES
    ('Blue Whale'),
    ('Humpback Whale'),
    ('Orca');

INSERT INTO Whale (conservation_status_id, diet_id, whale_species_id, whaleName)
VALUES
    (1, 1, 1, 'Big Blue'),
    (2, 2, 2, 'Humpy');

INSERT INTO WhaleTrackerHistory (lat, lon, ocean_id, timestamp, whale_id)
VALUES
    (33.9, -118.4, 1, CURRENT_TIMESTAMP, 1),
    (52.5, -1.9, 2, CURRENT_TIMESTAMP, 2);
