package com.github.galcyurio.config

import groovy.transform.Canonical
import groovy.transform.TupleConstructor

/**
 * @author galcyurio
 */
@Canonical
@TupleConstructor
class Configuration {
    public static final API_URL = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/"

    String serviceKey

    Configuration(String serviceKey) {
        this.serviceKey = serviceKey
    }
}
