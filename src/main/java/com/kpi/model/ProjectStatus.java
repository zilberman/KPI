package com.kpi.model;

public enum ProjectStatus {
    DRAFT, STARTED, IN_PROGRESS, SUSPENDED, CLOSED;

    @Override
    public String toString() {
        final String result = this.name().replace('-', ' ');
        final String lower = result.substring(1).toLowerCase();
        return result.charAt(0) + lower;
    }
}
