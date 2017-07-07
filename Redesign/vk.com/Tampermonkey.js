// ==UserScript==
// @name         VK removes friends names
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       Skevary
// @match        https://vk.com/*
// @grant        none
// ==/UserScript==


var className = "people_cell_name";
var elements = document.getElementsByClassName(className);
while(elements.length > 0){
    elements[0].parentNode.removeChild(elements[0]);
}


