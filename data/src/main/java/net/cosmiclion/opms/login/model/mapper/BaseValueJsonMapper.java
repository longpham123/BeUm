///**
// * Copyright (C) 2015 Fernando Cejas Open Source Project
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package net.cosmiclion.opms.login.model.mapper;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonSyntaxException;
//import com.google.gson.reflect.TypeToken;
//
//import java.lang.reflect.Type;
//
//import javax.inject.Inject;
//
///**
// * Class used to transform from Strings representing json to valid objects.
// */
//public class BaseValueJsonMapper {
//
//  private final Gson gson;
//
//  @Inject
//  public BaseValueJsonMapper() {
//    this.gson = new Gson();
//  }
//
//  /**
//   * Transform from valid json string to {@link BaseValueResponse}.
//   *
//   * @param baseValueJsonResponse A json representing a base value.
//   * @return {@link BaseValueResponse}.
//   * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
//   */
//  public BaseValueResponse transformBaseValue(String baseValueJsonResponse) throws JsonSyntaxException {
//    try {
//      Type baseValueType = new TypeToken<BaseValueResponse>() {}.getType();
//      BaseValueResponse baseValueResponse = this.gson.fromJson(baseValueJsonResponse, baseValueType);
//      return baseValueResponse;
//    } catch (JsonSyntaxException jsonException) {
//      throw jsonException;
//    }
//  }
//
//}
