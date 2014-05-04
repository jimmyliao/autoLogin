var webdriver = require('selenium-webdriver'),
    SeleniumServer = require('selenium-webdriver/remote').SeleniumServer;

var server = new SeleniumServer("./selenium-server-standalone-2.39.0.jar", {
  port: 4444
});

server.start();
/*
var driver = new webdriver.Builder().
    usingServer(server.address()).
    withCapabilities(webdriver.Capabilities.firefox()).
    build();
*/
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

/*
var assert = require('assert'),
    test = require('selenium-webdriver/testing');
//    webdriver = require('selenium-webdriver');

test.describe('Google Search', function() {
  test.it('should work', function() {
    var driver = new webdriver.Builder().build();

    var searchBox = driver.findElement(webdriver.By.name('q'));
    searchBox.sendKeys('webdriver');
    searchBox.getAttribute('value').then(function(value) {
      assert.equal(value, 'webdriver');
    });

    driver.quit();
  });
});
*/

//var webdriverjs = require('webdriverjs');

//var options = { desiredCapabilities: { browserName: 'firefox' } };

/*
webdriverjs
	.remote(options)
	.init()
	.url('http://www.google.com')
	.title(function(err, res) {
	  console.log('Title was: ' + res.value);
	})
	.end();
*/

