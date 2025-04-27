"use strict"

import fetchData from "./fetchApi.js";
import processData from "./processData.js";

const errorMessage = document.getElementById('error-message');

const ADMIN_PRIVILEGE_DOM = {
    deleteTrack: document.getElementById("delete-track")
}

ADMIN_PRIVILEGE_DOM.deleteTrack.addEventListener("click", async () => {
    let id = document.getElementById("track-id")

    if (id.value !== "") {
        let url = `${ADMIN_PRIVILEGE_DOM.deleteTrack.dataset.url}/${id.value}`

    }
})
