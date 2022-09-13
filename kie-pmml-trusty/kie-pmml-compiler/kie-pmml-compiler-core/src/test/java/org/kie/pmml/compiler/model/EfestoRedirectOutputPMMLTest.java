/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.pmml.compiler.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.kie.efesto.common.api.identifiers.LocalUri;
import org.kie.efesto.common.api.identifiers.ModelLocalUriId;

import static org.assertj.core.api.Assertions.assertThat;

class EfestoRedirectOutputPMMLTest {

    private static ModelLocalUriId modelLocalUriId;

    @BeforeAll
    public static void setup() {
        String path = "/example/some-id/instances/some-instance-id";
        LocalUri parsed = LocalUri.parse(path);
        modelLocalUriId = new ModelLocalUriId(parsed);
    }

    @Test
    void constructor() {
        String modelFile = "modelFile";
        EfestoRedirectOutputPMML retrieved = new EfestoRedirectOutputPMML(modelLocalUriId, modelFile);
        assertThat(retrieved.getModelLocalUriId()).isEqualTo(modelLocalUriId);
        assertThat(retrieved.getFullClassNames()).isNull();
    }

    @Test
    void getTargetEngine() {
        String modelFile = "modelFile";
        EfestoRedirectOutputPMML retrieved = new EfestoRedirectOutputPMML(modelLocalUriId, modelFile);
        assertThat(retrieved.getTargetEngine()).isEqualTo("drl");
    }

    @Test
    void getContent() {
        String modelFile = "modelFile";
        EfestoRedirectOutputPMML retrieved = new EfestoRedirectOutputPMML(modelLocalUriId, modelFile);
        assertThat(retrieved.getContent()).isEqualTo(modelFile);
    }
}