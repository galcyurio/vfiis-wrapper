package com.github.galcyurio.config

import groovy.transform.Canonical
/**
 * @author galcyurio
 */
@Canonical
class Configuration {
    String serviceKey

    Configuration(String serviceKey) {
        this.serviceKey = URLDecoder.decode(serviceKey, "utf-8")
    }
}
