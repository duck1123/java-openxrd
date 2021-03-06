/*
 * Copyright [2009] [University Corporation for Advanced Internet Development, Inc.]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openxrd;

import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * OpenXRD configuration singleton.
 * 
 * The library must be initialized with a set of configurations prior to usage. This is often done by invoking
 * {@link DefaultBootstrap#bootstrap()} but may done in any manner so long as all the needed object providers and
 * artifact factory are created and registered with the configuration.
 */
public class Configuration extends org.opensaml.xml.Configuration {

    /** Date format in XRD object, default is yyyy-MM-dd'T'HH:mm:ss.SSS'Z'. */
    private static String defaultDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /** Formatter used to write dates. */
    private static DateTimeFormatter dateFormatter;

    /**
     * Gets the date format used to string'ify XRD's {@link org.joda.time.DateTime} objects.
     * 
     * @return date format used to string'ify date objects
     */
    public static DateTimeFormatter getXRDDateFormatter() {
        if (dateFormatter == null) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(defaultDateFormat);
            dateFormatter = formatter.withChronology(ISOChronology.getInstanceUTC());
        }

        return dateFormatter;
    }

    /**
     * Sets the date format used to string'ify XRD's date/time objects.
     * 
     * See the
     * {@link <a href="http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html">SimpleDateFormat</a>}
     * documentation for format syntax.
     * 
     * @param format date format used to string'ify date objects
     */
    public static void setXRDDateFormat(String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        dateFormatter = formatter.withChronology(ISOChronology.getInstanceUTC());
    }

}