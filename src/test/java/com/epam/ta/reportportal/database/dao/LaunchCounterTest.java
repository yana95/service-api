/*
 * Copyright 2016 EPAM Systems
 * 
 * 
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/service-api
 * 
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.epam.ta.reportportal.database.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;

/**
 * Unit test for launch meta info repository
 *
 * @author Andrei Varabyeu
 */
public class LaunchCounterTest extends BaseDaoContextTest {

	@Autowired
	private LaunchMetaInfoRepository launchMetaInfoRepository;

	@Test
	public void testLaunchCounterForNewName() throws Exception {
		long number = launchMetaInfoRepository.getLaunchNumber(
				RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphabetic(5));
		Assert.assertThat(number, is(1L));
	}
}