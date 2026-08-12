const { chromium } = require('playwright');

const URL='https://parsons.wd5.myworkdayjobs.com/en-US/Search/job/XMLNAME--Junior-Signage---Wayfinding-Designer_R181421';

(async()=>{
 const browser=await chromium.launch({channel:'chrome',headless:true}); const page=await browser.newPage({viewport:{width:1440,height:1600}}); page.setDefaultTimeout(25000);
 const res=await page.goto(URL,{waitUntil:'domcontentloaded',timeout:60000});
 const apply=page.locator('[data-automation-id="adventureButton"]');
 await apply.waitFor({state:'visible',timeout:15000});
 console.log('LIVE='+JSON.stringify({http:res&&res.status(),title:(await page.locator('[data-automation-id="jobPostingHeader"]').innerText()).trim(),posted:(await page.locator('[data-automation-id="postedOn"]').innerText()).replace(/\s+/g,' ').trim(),body:(await page.locator('body').innerText()).replace(/\s+/g,' ').slice(0,3000)}));
 await apply.click(); await page.waitForTimeout(700);
 const buttons=(await page.getByRole('button').allTextContents()).map(x=>x.trim()).filter(Boolean); console.log('APPLY_OPTIONS='+JSON.stringify(buttons));
 const manual=page.getByRole('button',{name:/apply manually/i});
 if(await manual.count()){await manual.click(); await page.waitForTimeout(1800);} else {const useResume=page.getByRole('button',{name:/apply with.*resume|manual/i}).first(); if(await useResume.count()) await useResume.click();}
 console.log('APPLICATION_URL='+page.url()); console.log('APPLICATION_BODY='+(await page.locator('body').innerText()).replace(/\s+/g,' ').slice(0,8500));
 console.log('FIELDS='+JSON.stringify(await page.locator('input,textarea,select').evaluateAll(els=>els.map((e,i)=>({i,tag:e.tagName,id:e.id,name:e.name,type:e.type,placeholder:e.placeholder,aria:e.getAttribute('aria-label'),required:e.required,value:e.value||null})).filter(x=>x.id||x.name||x.placeholder||x.aria))));
 console.log('BUTTONS='+JSON.stringify((await page.getByRole('button').allTextContents()).map(x=>x.trim()).filter(Boolean)));
 await browser.close();
})().catch(e=>{console.error(e.stack||e);process.exit(1)});
