var webdriverjs = require('webdriverjs');

var options = { desiredCapabilities: { browserName: 'firefox' } };

webdriverjs
	.remote(options)
	.init()
	.url('http://www.google.com')
	.title(function(err, res) {
	  console.log('Title was: ' + res.value);
	})
	.end();
