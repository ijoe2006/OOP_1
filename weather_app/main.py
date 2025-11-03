import os
import requests
from dotenv import load_dotenv

# Load environment variables from .env file
load_dotenv()
API_KEY = os.getenv("OWM_API_KEY")

BASE_URL = "https://api.openweathermap.org/data/2.5/weather"

def get_weather(city, units):
    """Fetch weather data from OpenWeatherMap for a given city."""
    params = {
        "q": city,
        "appid": API_KEY,
        "units": units
    }

    try:
        response = requests.get(BASE_URL, params=params)
        response.raise_for_status()
        data = response.json()

        # Parse and display relevant fields
        name = data.get("name", "Unknown city")
        country = data.get("sys", {}).get("country", "N/A")
        weather = data.get("weather", [{}])[0].get("description", "N/A").capitalize()
        temp = data.get("main", {}).get("temp", "N/A")
        humidity = data.get("main", {}).get("humidity", "N/A")
        wind_speed = data.get("wind", {}).get("speed", "N/A")

        print(f"\nWeather for {name}, {country}")
        print(f"Condition: {weather}")
        print(f"Temperature: {temp}° {'C' if units == 'metric' else 'F'}")
        print(f"Humidity: {humidity}%")
        print(f"Wind Speed: {wind_speed} {'m/s' if units == 'metric' else 'mph'}")

    except requests.exceptions.HTTPError as err:
        print(f"Error: {err}")
    except requests.exceptions.RequestException:
        print("Network error. Please check your connection.")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")

def main():
    """Main program loop."""
    print("Welcome to the Python Weather App!")
    while True:
        city = input("\nEnter a city name (or type 'exit' to quit): ").strip()
        if city.lower() == "exit":
            print("Goodbye!")
            break

        unit_choice = input("Choose units - (C)elsius or (F)ahrenheit: ").strip().lower()
        units = "metric" if unit_choice.startswith("c") else "imperial"

        get_weather(city, units)

if __name__ == "__main__":
    main()
