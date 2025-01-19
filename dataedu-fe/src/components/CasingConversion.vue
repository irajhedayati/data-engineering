<template>
  <form>
    <div class="row">
      <div class="col-4">
        <div class="mb-3">
          <label class="form-label" for="inputCasingConverted">Original</label>
          <input id="inputCasingOriginal" v-model="input" class="form-control" placeholder="Input string" type="text">
        </div>
      </div>
      <div class="col-4">
        <div class="mb-3">
          <label class="form-label" for="inputCasingConverted">&nbsp;</label>
          <select id="inputCasingTarget" v-model="target" class="form-select" name="unit">
            <option value="">Select target</option>
            <option>UpperCaseCamelCase</option>
            <option>lowerCaseCamelCase</option>
            <option>kebab-case</option>
            <option>snake_case</option>
          </select>
        </div>
      </div>
      <div class="col-4">
        <div class="mb-3">
          <label class="form-label" for="inputCasingConverted">Converted</label>
          <input id="inputCasingConverted" class="form-control" placeholder="Output" type="text" v-model="converted">
        </div>
      </div>
    </div>
    <div class="row-cols-2">
      Input casing: {{ inputCasing }}
    </div>
  </form>
</template>
<script>
export default {
  data () {
    return {
      input: '',
      target: ''
    }
  },
  computed: {
    inputCasing () {
      if (this.input.match('^([A-Z][a-z0-9]+|[A-Z]+)+$')) {
        return 'UpperCaseCamelCase'
      } else if (this.input.match('^([a-z0-9]+)([A-Z][a-z0-9]+|[A-Z]+)*$')) {
        return 'lowerCaseCamelCase'
      } else if (this.input.match('^([a-z0-9\\-]+)$')) {
        return 'kebab-case'
      } else if (this.input.match('^([a-z0-9_]+)$')) {
        return 'snake_case'
      } else {
        return ''
      }
    },
    converted () {
      if (this.inputCasing === this.target) {
        return this.input
      } else {
        switch (this.inputCasing + '-' + this.target) {
          case 'UpperCaseCamelCase-kebab-case':
            return this.camelCaseToKebabCase(this.input)
          case 'UpperCaseCamelCase-lowerCaseCamelCase':
            return this.upperCamelCaseToLowerCamelCase(this.input)
          case 'UpperCaseCamelCase-snake_case':
            return this.camelCaseToSnakeCase(this.upperCamelCaseToLowerCamelCase(this.input))
          case 'lowerCaseCamelCase-kebab-case':
            return this.camelCaseToKebabCase(this.input)
          case 'lowerCaseCamelCase-UpperCaseCamelCase':
            return this.lowerCamelCaseToUpperCamelCase(this.input)
          case 'lowerCaseCamelCase-snake_case':
            return this.camelCaseToSnakeCase(this.input)
          case 'kebab-case-UpperCaseCamelCase':
            return this.lowerCamelCaseToUpperCamelCase(this.kebabCaseToCamelCase(this.input))
          case 'kebab-case-lowerCaseCamelCase':
            return this.kebabCaseToCamelCase(this.input)
          case 'kebab-case-snake_case':
            return this.camelCaseToSnakeCase(this.kebabCaseToCamelCase(this.input))
          case 'snake_case-UpperCaseCamelCase':
            return this.lowerCamelCaseToUpperCamelCase(this.snakeCaseToCamelCase(this.input))
          case 'snake_case-lowerCaseCamelCase':
            return this.snakeCaseToCamelCase(this.input)
          case 'snake_case-kebab-case':
            return this.camelCaseToKebabCase(this.snakeCaseToCamelCase(this.input))
          default:
            return ''
        }
      }
    }
  },
  methods: {
    camelCaseToKebabCase (str) {
      return str.replace(/([a-z0-9])([A-Z])/g, '$1-$2').toLowerCase()
    },
    kebabCaseToCamelCase (str) {
      return str.replace(/-./g, m => m.toUpperCase()[1])
    },
    lowerCamelCaseToUpperCamelCase (str) {
      return str.charAt(0).toUpperCase() + str.slice(1)
    },
    upperCamelCaseToLowerCamelCase (str) {
      return str.charAt(0).toLowerCase() + str.slice(1)
    },
    camelCaseToSnakeCase (str) {
      return str.replace(/[A-Z]/g, letter => `_${letter.toLowerCase()}`)
    },
    snakeCaseToCamelCase (str) {
      return str.replace(/(_\w)/g, k => k[1].toUpperCase())
    }
  }
}
</script>
