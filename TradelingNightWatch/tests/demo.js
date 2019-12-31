module.exports = {
  'first end-to-end test': function (browser) {
      browser
        .url('https:www.binance.com/en')
        .waitForElementVisible('body')
        .assert.titleContains('Bitcoin')

        .assert.visible("[class='sc-bdVaJa sc-bwzfXH sc-19yy82s-1 ilXDgj']")
        .click("[class='sc-bdVaJa sc-bwzfXH sc-19yy82s-1 ilXDgj']")
        .assert.visible("[class] [class='sc-1ipci53-0 kdnBBp']:nth-of-type(1) strong")
        .click("[class] [class='sc-1ipci53-0 kdnBBp']:nth-of-type(1) strong")
        .assert.visible("[class='sc-1t2bpae-0 OXkQZ']")
        .assert.containsText('.kAVJLh.sc-1t2bpae-4.sc-1t2bpae-5 > li:nth-of-type(1)', 'Original')
        .assert.containsText('a#TabbedOrderFormsMargin-a-exchange > span', 'Exchange')
        .assert.containsText("div[role='columnheader'] > span[title='Total(BTC)']", 'Total(BTC)')
      },
      'second end-to-end test' : function (browser) {
        browser
        .waitForElementVisible('input#FormRow-BUY-price')
        .assert.visible("input#FormRow-BUY-price")
        .setValue('input#FormRow-BUY-price', ['', [browser.Keys.CONTROL, "a"]])
        .keys('\uE017')
        .setValue('input#FormRow-BUY-price', '10')
        .setValue('input#FormRow-BUY-quantity', '10')
        .click("div:nth-of-type(1) > .gHnHSI.sc-1lt5gnu-0 h3")
        .assert.containsText('input#FormRow-BUY-total', '100.00000000')
        .end();
        
      
    }
  };