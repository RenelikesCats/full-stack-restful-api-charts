export default function processData(tracks, trackList) {
    trackList.innerHTML = ""
    if (tracks && tracks.length > 0) {
        tracks.forEach(track => {
            const trackDiv = document.createElement('div');
            trackDiv.classList.add('track-item');

            const titleHeading = document.createElement('h3');
            titleHeading.textContent = track.trackName;

            const nameDetail = document.createElement('p');
            nameDetail.classList.add('track-detail');
            nameDetail.textContent = `Artist: ${track.artistName}`;

            const dateDetail = document.createElement('p');
            dateDetail.classList.add('track-detail');
            dateDetail.textContent = `Date: ${track.date}`;

            const streamsDetail = document.createElement('p');
            streamsDetail.classList.add('track-detail');
            streamsDetail.textContent = `Streams: ${track.streams}`;

            trackDiv.appendChild(titleHeading);
            trackDiv.appendChild(nameDetail);
            trackDiv.appendChild(dateDetail);
            trackDiv.appendChild(streamsDetail);

            trackList.appendChild(trackDiv);
        });
    } else {
        trackList.textContent = 'No tracks found.';
    }
}