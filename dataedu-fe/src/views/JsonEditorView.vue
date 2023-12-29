<template>
<div class="container overflow-hidden">
  <div class="row py-1">
    <div class="col-2">
      <button type="button" class="btn btn-primary" @click="saveTextAsFile">Download</button>
    </div>
  </div>
  <div class="row py-1" style="height: 500px;">
    <div class="col-12">
      <v-ace-editor
        v-model:value="content"
        lang="json"
        theme="chrome"
        style="height: 500px;"
        options="{
            'useWorker': true
        }"
      />
    </div>
  </div>
</div>
</template>

<script>
import { VAceEditor } from 'vue3-ace-editor'
import ace from 'ace-builds'
import 'ace-builds/src-noconflict/mode-json'
import 'ace-builds/src-noconflict/theme-chrome'
// eslint-disable-next-line import/no-webpack-loader-syntax
import workerJsonUrl from 'file-loader?esModule=false!ace-builds/src-noconflict/worker-json.js'

ace.config.set(
  'basePath',
  'https://cdn.jsdelivr.net/npm/ace-builds@' + require('ace-builds').version + '/src-noconflict/')
ace.config.setModuleUrl('ace/mode/json_worker', workerJsonUrl)

export default {
  data () {
    return {
      content: ''
    }
  },
  components: {
    VAceEditor
  },
  methods: {
    saveTextAsFile () {
      const textFileAsBlob = new Blob([this.content], { type: 'text/plain' })
      const downloadLink = document.createElement('a')
      downloadLink.download = 'data_edu.json'
      downloadLink.innerHTML = 'Download File'
      if (window.webkitURL != null) {
        // Chrome allows the link to be clicked
        // without actually adding it to the DOM.
        downloadLink.href = window.webkitURL.createObjectURL(textFileAsBlob)
      } else {
        // Firefox requires the link to be added to the DOM
        // before it can be clicked.
        downloadLink.href = window.URL.createObjectURL(textFileAsBlob)
        // downloadLink.onclick = destroyClickedElement
        downloadLink.style.display = 'none'
        document.body.appendChild(downloadLink)
      }
      downloadLink.click()
    }
  }
}

</script>
