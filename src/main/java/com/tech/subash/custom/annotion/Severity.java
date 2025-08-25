package com.tech.subash.custom.annotion;

import jakarta.validation.Payload;

public class Severity {
    public interface Info extends Payload {}
    public interface Error extends Payload {}
}
