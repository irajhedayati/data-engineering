#!/usr/bin/env python
try:
    from urllib.request import urlopen
except ImportError:
    from urllib2 import urlopen
import json
import sys

# Modify COMPONENT_NAME to name your component differently.
COMPONENT_NAME = sys.argv[2]

gist_url = 'https://gist.github.com/{:s}.json'.format(sys.argv[1])
gist = json.loads(urlopen(gist_url).read())
html = gist['div']
resource = urlopen(gist['stylesheet'])
stylesheet = resource.read().decode('utf-8')

with open('./dataedu-fe/src/components/{:s}.vue'.format(COMPONENT_NAME), 'w') as f:
    f.write('<template>\n{:s}</template>\n'.format(html))
    f.write("<script>\nexport default {{ name: '{:s}' }}\n</script>\n".format(COMPONENT_NAME))
    f.write('<style>\n{:s}\n</style>\n'.format(stylesheet))
