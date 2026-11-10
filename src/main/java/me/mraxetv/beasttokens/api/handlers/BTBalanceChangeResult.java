package me.mraxetv.beasttokens.api.handlers;

import java.math.BigDecimal;

/** Checked immediate outcome; no durable receipt or exactly-once claim. */
public final class BTBalanceChangeResult {
    public enum Status { SUCCESS, REJECTED, UNKNOWN }
    private final Status status;
    private final String reason;
    private final BigDecimal before;
    private final BigDecimal after;
    public BTBalanceChangeResult(Status status, String reason, BigDecimal before, BigDecimal after) {
        if (status == null) throw new IllegalArgumentException("status cannot be null");
        this.status = status;
        this.reason = reason == null ? "" : reason;
        this.before = before;
        this.after = after;
    }
    public Status status() { return status; }
    public String reason() { return reason; }
    public BigDecimal before() { return before; }
    public BigDecimal after() { return after; }
    public boolean successful() { return status == Status.SUCCESS; }
}
