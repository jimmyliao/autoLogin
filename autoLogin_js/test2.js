//var webdriver = require('selenium-webdriver');
/*
var driver = new webdriver.Builder().
    withCapabilities(webdriver.Capabilities.firefox()).
    build();
*/
//driver.get('http://www.google.com');

if (! String.prototype.repeat) {
    String.prototype.repeat = function (times) {
        return new Array(times+1).join(this);
    }
}	

describe("repeat", function() {
    it("repeats strings", function() {
        expect("abc".repeat(2)).toEqual("abcabc");
        expect("abc".repeat(0)).toEqual("");
    });
});

/*	
describe('basic test', function () {
	var webdriver = require('selenium-webdriver');
	var driver = new webdriver.Builder().
	    withCapabilities(webdriver.Capabilities.firefox()).
	    build();

	it('should be on correct page', function () {
		driver.get('http://www.google.com');
		driver.getTitle().then(function(title) {
			expect(title).toBe('Google');
			// Jasmine waits for the done callback to be called before proceeding to next specification.
			done();
		});
	});
});
*/	
