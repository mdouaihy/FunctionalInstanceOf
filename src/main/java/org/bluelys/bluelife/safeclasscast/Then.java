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
 * Represents a Then action to provide a Then return statement.
 */
public interface Then<T> {
    /**
     * Provides a Then Return statement.
     *
     * @param input the return statement
     * @return a Chain object that allows chaining calls or returning value.
     */
    <R> Chain<R> then(Return<T, R> input);
}
