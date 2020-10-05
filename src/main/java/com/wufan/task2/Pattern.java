package com.wufan.task2;

/**
 * @Author HeHao
 * @Date 2020/9/8 10:55
 * @Version 1.0
 */
public enum Pattern {
    /**
     * SCNP:SingleChannelNonPreemptive(单道非抢占式)
     * SCP:SingleChannelPreemptive(单道抢占式)
     * MCNP:MultipleChannelNonPreemptive(多道非抢占式)
     * MCP:MultipleChannelPreemptive(多道抢占式)
     */
    SCNP("SingleChannelNonPreemptive"), SCP("SingleChannelPreemptive"),
    MCNP("MultipleChannelNonPreemptive"), MCP("MultipleChannelPreemptive");
    private String fullName;

    Pattern(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
