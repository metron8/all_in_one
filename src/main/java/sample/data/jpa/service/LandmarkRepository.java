/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sample.data.jpa.domain.Landmark;

@RepositoryRestResource(collectionResourceRel = "Landmark", path = "Landmark")
public interface LandmarkRepository extends PagingAndSortingRepository<Landmark, Long> {

	Page<Landmark> findByNameContainingAndCountryContainingAllIgnoringCase(
			@Param("name") String name, @Param("country") String country,
			Pageable pageable);

	Landmark findByNameAndCountryAllIgnoringCase(@Param("name") String name,
			@Param("country") String country);

}
