/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        'myColor': '#1994a7'
      },
      height:{
        '10v' : '10vh',
        '80v' : '80vh',
        '90v' : '90vh'
      },
      screens: {
        'xss': '480px'
      }
    },
  },
  plugins: [],
}

