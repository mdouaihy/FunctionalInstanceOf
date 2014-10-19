/*
 * Copyright 2014 Mehrez DOUAIHY
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bluelys.bluelife.safeclasscast;


/**
 * Interface to chain calls.
 * @param <R> the return type.
 */
public interface Chain<R> extends Value<R> {

    /**
     * Specifies a new expected type and instantiate an associated Then object.
     *
     * @param tClass the expected type.
     * @param <T> the return type.
     * @return a Then object associated to the specified class.
     */
    <T> Then<T> elseof(Class<T> tClass) ;

    /**
     * Specifies a default value to return.
     *
     * @param value the default value.
     * @return the value of the chained calls.
     */
    R otherwise(R value) ;

    /**
     * Specifies a default Return.
     *
     * @param returnObject the default Return object.
     * @return the value of the chained calls.
     */
    R otherwise(Return<Object, R> returnObject);
}
