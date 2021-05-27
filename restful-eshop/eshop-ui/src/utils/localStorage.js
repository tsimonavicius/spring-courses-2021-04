export const saveToLocalStorage = (key, value) => {

	try {
		const serializedValue = JSON.stringify(value)
		localStorage.setItem(key, serializedValue)
	} catch {
		// ignore
	}
}
