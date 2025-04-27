"use strict";

import fetchData from "./fetchApi.js";
import processData from "./processData.js";

const tracksContainer = document.getElementById('tracks-container');
const responseContainer = document.getElementById("response-container")
const errorMessage = document.getElementById('error-message');

const GUEST_PRIVILEGE_DOM = {
    allTracks: document.getElementById("get-all-tracks"),
    soloTracks: document.getElementById("get-solo-artists"),
    filterYear: document.getElementById("filter-by-year"),

    platform: document.getElementById("platform"),
    filterPlatformBtn: document.getElementById("filter-by-platform-rank"),
    rankInput: document.getElementById("rank")
}

let platformChoice = "spotify"

GUEST_PRIVILEGE_DOM.allTracks.addEventListener("click", async () => {
    responseContainer.hidden = false
    const url = GUEST_PRIVILEGE_DOM.allTracks.dataset.url
    try {
        errorMessage.style.display = 'none'
        const tracks = await fetchData(url)
        processData(tracks, tracksContainer)
    } catch (error) {
        errorMessage.style.display = 'block'
    }
});

GUEST_PRIVILEGE_DOM.soloTracks.addEventListener("click", async () => {
    responseContainer.hidden = false
    const url = GUEST_PRIVILEGE_DOM.soloTracks.dataset.url
    try {
        errorMessage.style.display = 'none'
        const tracks = await fetchData(url)
        processData(tracks, tracksContainer)
    } catch (error) {
        errorMessage.style.display = 'block'
    }
})

GUEST_PRIVILEGE_DOM.filterYear.addEventListener("click", async () => {
    let input = document.getElementById("releaseYear")
    if (input.value !== "") {
        const url = `${GUEST_PRIVILEGE_DOM.filterYear.dataset.url}${input.value}`
        try {
            errorMessage.style.display = 'none'
            const tracks = await fetchData(url)
            processData(tracks, tracksContainer)
        } catch (error) {
            errorMessage.style.display = 'block'
        }
    }
    input.value = ""
})

GUEST_PRIVILEGE_DOM.platform.addEventListener("change", () => {
    platformChoice = GUEST_PRIVILEGE_DOM.platform.value
})

GUEST_PRIVILEGE_DOM.filterPlatformBtn.addEventListener("click", async () => {
    const inputValue = document.getElementById("rank").value
    if (inputValue !== "") {
        const url = `${GUEST_PRIVILEGE_DOM.filterPlatformBtn.dataset.url}${platformChoice}/rank?rank=${inputValue}`
        try {
            errorMessage.style.display = 'none'
            const tracks = await fetchData(url)
            processData(tracks, tracksContainer)
        } catch (error) {
            errorMessage.style.display = 'block'
        }
    }
})