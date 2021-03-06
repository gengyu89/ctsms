/*
 * Copyright 2009-2012 Prime Teknoloji.
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
package org.phoenixctms.ctsms.web.component.captcha;

import java.io.Serializable;

class Verification implements Serializable {

	private String challenge;
	private String answer;
	private String token;

	public Verification() {
		// NoOp
	}

	public Verification(String token) {
		this.challenge = null;
		this.answer = null;
		this.token = token;
	}

	public Verification(String challenge, String answer) {
		this.challenge = challenge;
		this.answer = answer;
		this.token = null;
	}

	public String getAnswer() {
		return answer;
	}

	public String getChallenge() {
		return challenge;
	}

	public String getToken() {
		return token;
	}
}