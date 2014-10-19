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
 * This utility is aimed to replace the use of instanceof operator.
 * With instanceof, you are obliged to to a runtime cast of the instance and this might be erroneous and might lead to runtime errors.
 * With this utility, Java type inference is used and the code won't even compile if the class is wrong.
 *
 * This is the main class to start composing.
 *
 * Call Instance.instance(someObject) to get an instance of Instance class. Then you can call of
 * method to start chaining calls based on the type of
 */
public final class Instance {

    private final Object object;

    /**
     * Private constructor.
     *
     * @param object the object which which class nature dictates the code that should be executed.
     */
    private Instance(Object object) {
        this.object = object;
    }

    /**
     * Returns and instance of Instance class.
     *
     * @param object the object which which class nature dictates the code that should be executed.
     * @return and instance of Instance to start chaining calls.
     */
    public static Instance instance(Object object) {
        return new Instance(object);
    }

    /**
     * First chaining call. Tells the system that there is a code to execute if the class of the object is of type T.
     *
     * @param tClass the expected class of object.
     * @return a Then object to which a Return interface can be given
     */
    public <T, R> Then<T> of(Class<T> tClass) {
        return new ThenImpl<>(tClass, object, null);
    }

}
