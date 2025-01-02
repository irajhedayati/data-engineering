<template>
  <banner caption="A set of tools to practice Avro schema"
          title="Avro Schema"
  />

  <section class="wrapper">
    <div class="inner">
      <div class="text-center">
        <h2>Avro Schema tools</h2>
        <p>Tools to generate, test and learn Avro schema</p>
      </div>
      <div class="container">
        <div class="row mb-5">
          <div class="col-4">
            <label class="form-label" for="tool">Select a tool:</label>
            <select id="tool" v-model="selectedTool" class="form-select" name="tool">
              <option value="jsonToAvro">Infer Avro from JSON</option>
              <option value="avroToIdl">Convert Avro schema to IDL</option>
              <option value="idlToAvro">Convert Avro IDL to schema</option>
              <option value="avroToHive">Convert Avro schema to HiveQL</option>
              <option value="flatAvro">Flatten an Avro schema</option>
            </select>
          </div>
        </div>
        <div class="row mb-4">
          <div class="col">
            <h4>{{ template[selectedTool].toolTitle }}</h4>
            <span v-html="template[selectedTool].toolDesc"></span>
          </div>
        </div>
        <div class="row mb-2">
          <div class="col-3"><h6>{{ template[selectedTool].inputTitle }}</h6></div>
          <div class="col-3 text-end">
            <button class="btn btn-primary" type="button" @click="this[selectedTool]">Generate</button>
          </div>
          <div class="col-3"><h6>{{ template[selectedTool].outputTitle }}</h6></div>
          <div class="col-3 text-end">
            <button class="btn btn-success" type="button">Download</button>
          </div>
        </div>
        <div class="row mb-2">
          <div class="col-6">
            <v-ace-editor
              v-model:value="input"
              :lang="template[selectedTool].inputLang"
              style="height: 500px;"
              theme="chrome"
            />
          </div>
          <div class="col-6">
            <v-ace-editor
              v-model:value="output"
              :lang="template[selectedTool].outputLang"
              style="height: 500px;"
              theme="chrome"
            />
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { VAceEditor } from 'vue3-ace-editor'
import ace from 'ace-builds'
import 'ace-builds/src-noconflict/mode-json'
import 'ace-builds/src-noconflict/mode-c_cpp'
import 'ace-builds/src-noconflict/mode-sql'
import 'ace-builds/src-noconflict/theme-chrome'
// eslint-disable-next-line import/no-webpack-loader-syntax
import workerJsonUrl from 'file-loader?esModule=false!ace-builds/src-noconflict/worker-json.js'
import Banner from '@/components/Banner.vue'
import axios from 'axios'

ace.config.set(
  'basePath',
  `https://cdn.jsdelivr.net/npm/ace-builds@${require('ace-builds').version}/src-noconflict/`)
ace.config.setModuleUrl('ace/mode/json_worker', workerJsonUrl)
// ace.config.setModuleUrl('ace/mode/c_cpp_worker', workerCppUrl)

const client = axios.create({ baseURL: process.env.VUE_APP_SCHEMA_API_URL })

export default {
  data () {
    return {
      selectedTool: 'jsonToAvro',
      input: '',
      output: '',
      template: {
        jsonToAvro: {
          toolTitle: 'Infer Avro schema from JSON documents',
          toolDesc: 'First type in a JSON document in the left panel and then click on "Generate". The corresponding inferred Avro schema will show up in the left panel.<br> You could also use a JSON array as the input. In that case, the inferred schema is designed to accept all the items of the Array.<br><strong>Note that only JSON record or JSON array of records is acceptable.</strong>',
          inputTitle: 'JSON document',
          outputTitle: 'Avro Schema',
          inputLang: 'json',
          outputLang: 'json',
          outputFileName: 'avro.avsc'
        },
        avroToIdl: {
          toolTitle: 'Convert Avro schema to Avro IDL',
          toolDesc: 'Type in the Avro schema in the left panel and click "Generate". The equivalent Avro IDL will be generated on the right side.<br> <strong>The name space and protocol is given a default value and namespace is set to "null"</strong>',
          inputTitle: 'Avro schema',
          outputTitle: 'Avro IDl',
          inputLang: 'json',
          outputLang: 'c_cpp',
          outputFileName: 'avro.avdl'
        },
        idlToAvro: {
          toolTitle: 'Convert Avro IDL to Avro schema',
          toolDesc: 'Type in the Avro IDL in the left panel and click "Generate". The equivalent Avro schema protocol will be generate on the right side.',
          inputTitle: 'Avro IDL',
          outputTitle: 'Avro schema',
          inputLang: 'c_cpp',
          outputLang: 'json',
          outputFileName: 'avro.avsc'
        },
        avroToHive: {
          toolTitle: 'Convert Avro schema to HiveSQL CREATE TABLE',
          toolDesc: 'Type in the Avro schema in the left panel and click "Generate". The equivalent CREATE TABLE compatible with HiveQL will be generated on the right side',
          inputTitle: 'Avro schema',
          outputTitle: 'Hive DDL',
          inputLang: 'json',
          outputLang: 'sql',
          outputFileName: 'avro.sql'
        },
        flatAvro: {
          toolTitle: 'Convert Avro schema to its flatten version',
          toolDesc: 'This tool generates the flatten version of an Avro schema. First type in the Avro schema in the left box and click on "Generate". The flat version will be generated on the right side.',
          inputTitle: 'Avro schema',
          outputTitle: 'Flatten Avro schema',
          inputLang: 'json',
          outputLang: 'json',
          outputFileName: 'avro.avsc'
        }
      }
    }
  },
  components: { Banner, VAceEditor },
  methods: {
    jsonToAvro () {
      client
        .post('/avro/api/v1/json-doc-to-avro', this.input, {
          headers: { 'Content-Type': 'application/json' }
        })
        .then(response => (this.output = JSON.stringify(response.data, null, 2)))
        .catch(error => alert(error.message))
    },
    avroToIdl () {
      client
        .post('/avro/api/v1/avro-to-idl', this.input, {
          headers: { 'Content-Type': 'application/json' }
        })
        .then(response => (this.output = response.data))
        .catch(error => alert(error.message))
    },
    idlToAvro () {
      client
        .post('/avro/api/v1/idl-to-avro', this.input, {
          headers: {
            'Content-Type': 'text/plain'
          }
        })
        .then(response => (this.output = JSON.stringify(response.data, null, 2)))
        .catch(error => alert(error.message))
    },
    avroToHive () {
      client
        .post('/avro/api/v1/avro-to-hive', this.input, {
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(response => (this.output = response.data))
        .catch(error => alert(error.message))
    },
    flatAvro () {
      client
        .post('/avro/api/v1/flat-avro', this.input, {
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(response => (this.output = JSON.stringify(response.data, null, 2)))
        .catch(error => alert(error.message))
    }
  }
}
</script>
