"use strict"
import fetchData from "./fetchApi.js";
import processData from "./processData.js";

const errorMessage = document.getElementById('error-message');
const platform = document.getElementById("platform")
const adminMsg = document.getElementById("admin-msg")

const ADMIN_PRIVILEGE_DOM = {
    deleteTrack: document.getElementById("delete-track"),
    updateChartRankBtn: document.getElementById("update-chart-rank")
}

let platformChoice = "spotify"

platform.addEventListener("change", () => {
    console.log(platform.value)
    platformChoice = platform.value
})
ADMIN_PRIVILEGE_DOM.deleteTrack.addEventListener("click", async () => {
    errorMessage.hidden=true
    const id = document.getElementById("track-id")

    if (id.value !== "") {
        const url = `${ADMIN_PRIVILEGE_DOM.deleteTrack.dataset.url}/${id.value}`
        const response = await fetch(`${url}`, {
            method: 'DELETE'
        })
        if (response.ok) {

            adminMsg.textContent=`Track with id: ${id.value} has been deleted successfully!`

        } else if (response.status === 404) {
            adminMsg.textContent=`Track with id: ${id.value} not found!`
        } else {
           errorMessage.hidden=false
        }
    }
    id.value = ""
})

ADMIN_PRIVILEGE_DOM.updateChartRankBtn.addEventListener("click", async () => {
    errorMessage.hidden=true
    const id = document.getElementById("update-track-id")
    const rankNr = document.getElementById("update-rank")

    if (id.value !== "") {
        const url = `${ADMIN_PRIVILEGE_DOM.updateChartRankBtn.dataset.url}/${id.value}/${platformChoice}/setrank?rank=${rankNr.value}`
        console.log(url)
        const response = await fetch(`${url}`, {
            method: 'PUT'
        })
        if (response.ok) {
            adminMsg.textContent= "Updated!"
        } else if (response.status === 404) {
            adminMsg.textContent= `Track with id: ${id.value} not found!`
        } else {
           errorMessage.hidden=false
        }
    }
})

