export default async function fetchData(url) {
    const response = await fetch(url);
    if (response.ok) {
        return await response.json();
    }
    throw new Error()
}