/*
 * Copyright (c) 2017. App Media S/A - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tiago Aguiar <tiago.aguiar@moving.com.br>, 8/29/17 2:50 PM
 *
 */

package br.com.ramon.cardoso.marvel.utils;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

/**
 * Conatins methods of request need.
 *
 * @author tiago.aguiar @moving.com.br (Tiago Aguiar).
 */
public final class Requests {

    /**
     * Build params to any request and remove all param that are null of request.
     *
     * @param keys   the keys
     * @param values the values
     * @return the immutable map
     */
    public static ImmutableMap<String, String> buildParams(String[] keys, Object[] values) {
        ImmutableMap.Builder<String, String> options = ImmutableMap.builder();
        for (int i = 0; i < keys.length; i++) {
            Object value = values[i];
            if (value != null && !Strings.isNullOrEmpty(String.valueOf(value)))
                options.put(keys[i], String.valueOf(values[i]));
        }
        return options.build();
    }

}