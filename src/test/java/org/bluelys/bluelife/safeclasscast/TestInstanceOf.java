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


import org.fest.assertions.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.bluelys.bluelife.safeclasscast.Instance.instance;


public class TestInstanceOf {

    @DataProvider(name = "instances")
    public static Object[][] instances() {
        return new Object[][] {
                { 6, 6 },
                { "City", 4 },
                { 9.7, 9 },
                { new Object(), -1 }
        };
    }

    @Test(dataProvider = "instances")
    public void testWithFinalConstant(Object instance, Integer expectedResult) {
        Integer value = instance(instance)
                .of(String.class).then(new Return<String, Integer>() {
                    @Override
                    public Integer evaluate(String input) {
                        return input.length();
                    }
                })
                .elseof(Double.class).then(new Return<Double, Integer>() {
                    @Override
                    public Integer evaluate(Double input) {
                        return input.intValue();
                    }
                })
                .elseof(Integer.class).then(new Return<Integer, Integer>() {
                    @Override
                    public Integer evaluate(Integer input) {
                        return input;
                    }
                }).otherwise(-1);


        Assertions.assertThat(value).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "instances")
    public void testWithFinalExpression(Object instance, Integer expectedResult) {
        Integer value = instance(instance)
                .of(String.class).then(new Return<String, Integer>() {
                    @Override
                    public Integer evaluate(String input) {
                        return input.length();
                    }
                })
                .elseof(Double.class).then(new Return<Double, Integer>() {
                    @Override
                    public Integer evaluate(Double input) {
                        return input.intValue();
                    }
                })
                .elseof(Integer.class).then(new Return<Integer, Integer>() {
                    @Override
                    public Integer evaluate(Integer input) {
                        return input;
                    }
                }).otherwise(new Return<Object, Integer>() {
                    @Override
                    public Integer evaluate(Object input) {
                        return -1;
                    }
                });


        Assertions.assertThat(value).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "instances")
    public void testWithoutFinalExpression(Object instance, Integer expectedResult) {
        Integer value = instance(instance)
                .of(String.class).then(new Return<String, Integer>() {
                    @Override
                    public Integer evaluate(String input) {
                        return input.length();
                    }
                })
                .elseof(Double.class).then(new Return<Double, Integer>() {
                    @Override
                    public Integer evaluate(Double input) {
                        return input.intValue();
                    }
                })
                .elseof(Integer.class).then(new Return<Integer, Integer>() {
                    @Override
                    public Integer evaluate(Integer input) {
                        return input;
                    }
                })
                .elseof(Object.class).then(new Return<Object, Integer>() {
                    @Override
                    public Integer evaluate(Object input) {
                        return -1;
                    }
                }).value();


        Assertions.assertThat(value).isEqualTo(expectedResult);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testWithoutFinalExpression() {
        Integer value = instance(new Object())
                .of(String.class).then(new Return<String, Integer>() {
                    @Override
                    public Integer evaluate(String input) {
                        return input.length();
                    }
                })
                .elseof(Double.class).then(new Return<Double, Integer>() {
                    @Override
                    public Integer evaluate(Double input) {
                        return input.intValue();
                    }
                }).value();
    }
}
