"use strict";

import processData from "./processData.js";
import {newTrack} from "./newTrack.js";

const tracksContainer = document.getElementById('tracks-container');
const responseContainer = document.getElementById("response-container");

const errorMessage = document.getElementById('error-message');
const platform = document.getElementById("platform");
const adminMsg = document.getElementById("admin-msg");

const ADMIN_PRIVILEGE_DOM = {
    adminName: document.getElementById("admin-welcome"),
    findById: document.getElementById("find-by-id"),
    deleteTrack: document.getElementById("delete-track"),
    updateChartRankBtn: document.getElementById("update-chart-rank"),
    logOffBtn: document.getElementById("log-off"),
    trackIdInput: document.getElementById("track-id"),

    dataModel: document.getElementById("dataModal"),
    createTrackBtn: document.getElementById("createTrack"),
    dataModalSubmit: document.getElementById("dataModal-submit")
};

let platformChoice = "spotify";

const nameResponse = await fetch(`principal`)
await nameResponse === null ? ADMIN_PRIVILEGE_DOM.adminName.textContent = "Welcome, Admin!" : ADMIN_PRIVILEGE_DOM.adminName.textContent = `Welcome, ${await nameResponse.text()}`

platform.addEventListener("change", () => {
    console.log(platform.value);
    platformChoice = platform.value;
});

ADMIN_PRIVILEGE_DOM.findById.addEventListener("click", async () => {
    errorMessage.hidden = true;
    adminMsg.textContent = ""
    const url = `${ADMIN_PRIVILEGE_DOM.findById.dataset.url}/${ADMIN_PRIVILEGE_DOM.trackIdInput.value}`;

    try {
        const response = await fetch(url);
        if (response.ok) {
            responseContainer.hidden = false;
            const track = await response.json();
            processData(Array(track), tracksContainer);
        } else if (response.status === 404) {
            adminMsg.textContent = `Track with id: ${ADMIN_PRIVILEGE_DOM.trackIdInput.value} not found!`;
            tracksContainer.innerHTML = ""
        } else {
            errorMessage.hidden = false;
        }
    } catch (error) {
        errorMessage.hidden = false;
        errorMessage.textContent = "Failed to fetch track details.";
    } finally {
        ADMIN_PRIVILEGE_DOM.trackIdInput.value = ""
    }
});

ADMIN_PRIVILEGE_DOM.deleteTrack.addEventListener("click", async () => {
    errorMessage.hidden = true;

    if (ADMIN_PRIVILEGE_DOM.trackIdInput.value !== "") {
        const url = `${ADMIN_PRIVILEGE_DOM.deleteTrack.dataset.url}/${ADMIN_PRIVILEGE_DOM.trackIdInput.value}`;
        try {
            const response = await fetch(url, {
                method: 'DELETE'
            });
            if (response.ok) {
                adminMsg.textContent = `Track with id: ${ADMIN_PRIVILEGE_DOM.trackIdInput.value} has been deleted successfully!`;
            } else if (response.status === 404) {
                adminMsg.textContent = `Track with id: ${ADMIN_PRIVILEGE_DOM.trackIdInput.value} not found!`;
            } else {
                errorMessage.hidden = false;
            }
        } catch (error) {
            errorMessage.hidden = false;
            errorMessage.textContent = "Failed to delete track.";
        } finally {
            ADMIN_PRIVILEGE_DOM.trackIdInput.value = "";
        }
    }
});

ADMIN_PRIVILEGE_DOM.updateChartRankBtn.addEventListener("click", async () => {
    errorMessage.hidden = true;
    const updateTrackIdInput = document.getElementById("update-track-id");
    const rankNr = document.getElementById("update-rank");

    if (updateTrackIdInput.value !== "") {
        const url = `${ADMIN_PRIVILEGE_DOM.updateChartRankBtn.dataset.url}/${updateTrackIdInput.value}/${platformChoice}/setrank?rank=${rankNr.value}`;
        try {
            const response = await fetch(url, {
                method: 'PUT'
            });
            if (response.ok) {
                adminMsg.textContent = "Updated!";
            } else if (response.status === 404) {
                adminMsg.textContent = `Track with id: ${updateTrackIdInput.value} not found!`;
            } else {
                errorMessage.hidden = false;
            }
        } catch (error) {
            errorMessage.hidden = false;
            errorMessage.textContent = "Failed to update chart rank.";
        } finally {
            updateTrackIdInput.value = ""
        }
    }
});

document.getElementById("closeBtn").addEventListener("click", () => {
    ADMIN_PRIVILEGE_DOM.dataModel.style.display = "none";
})
ADMIN_PRIVILEGE_DOM.createTrackBtn.addEventListener("click", () => {
    ADMIN_PRIVILEGE_DOM.dataModel.style.display = 'block'
})
ADMIN_PRIVILEGE_DOM.dataModalSubmit.addEventListener("click", async (e) => {
    e.preventDefault();

    const formInputs = document.querySelectorAll("input.form-input");
    const numberOfInputs = formInputs.length;
    let validInputsCount = 0;

    formInputs.forEach(input => {
        if (input.checkValidity()) {
            validInputsCount++;
        }
    })

    if (validInputsCount === numberOfInputs) {
        const newTrackData = {...newTrack};
        formInputs.forEach(input => {
            if (newTrackData.hasOwnProperty(input.name)) {
                newTrackData[input.name] = input.value;
            }
        });
        const response = await fetch(`/tracks/new`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(newTrackData)
        })
        if (response.ok) {
           alert(`Track successfully added! Track id: ${await response.json()}`)
        }
        else{
            alert('Something went wrong!')
        }
    }
})