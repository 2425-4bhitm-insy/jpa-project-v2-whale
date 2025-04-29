package at.ac.htlleonding.control;

import java.time.LocalDate;

public record WhaleTrackingCountRecord(Long whaleId, LocalDate date, Long count) { }