export default function processData(tracks, trackList) {
    trackList.innerHTML = ""
    if (tracks && tracks.length > 0) {
        tracks.forEach(track => {
            const trackDiv = document.createElement('div');
            trackDiv.classList.add('track-item');

            const titleHeading = document.createElement('h3');
            titleHeading.textContent = track.trackName;

            const id= document.createElement('p')
            id.classList.add('track-detail');
            id.textContent=`Track Id: ${track.id}`

            const nameDetail = document.createElement('p');
            nameDetail.classList.add('track-detail');
            nameDetail.textContent = `Artist: ${track.artistName}`;

            const dateDetail = document.createElement('p');
            dateDetail.classList.add('track-detail');
            dateDetail.textContent = `Date: ${track.date}`;

            const streamsDetail = document.createElement('p');
            streamsDetail.classList.add('track-detail');
            streamsDetail.textContent = `Streams: ${track.streams}`;

            const spotify = document.createElement('p')
            spotify.classList.add('track-detail')
            spotify.textContent=`Spotify rank: ${track.spotify}`

            const apple = document.createElement('p')
            apple.classList.add('track-detail')
            apple.textContent=`Apple rank: ${track.apple}`

            const deezer = document.createElement('p')
            deezer.classList.add('track-detail')
            deezer.textContent=`Deezer rank: ${track.deezer}`

            const shazam = document.createElement('p')
            shazam.classList.add('track-detail')
            shazam.textContent=`Shazam rank: ${track.shazam}`

            trackDiv.appendChild(titleHeading);
            trackDiv.appendChild(id)
            trackDiv.appendChild(nameDetail);
            trackDiv.appendChild(dateDetail);
            trackDiv.appendChild(streamsDetail);
            trackDiv.appendChild(spotify)
            trackDiv.appendChild(apple)
            trackDiv.appendChild(deezer)
            trackDiv.appendChild(shazam)

            trackList.appendChild(trackDiv);
        });
    } else {
        trackList.textContent = 'No tracks found.';
    }
}