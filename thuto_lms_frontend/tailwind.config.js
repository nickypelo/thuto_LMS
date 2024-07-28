/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        'myColor': '#1994a7',
      },
      height:{
        '10v' : '10vh',
        '80v' : '79vh',
        '90v' : '90vh'
      },
      screens: {
        'xss': '480px'
      },
      backgroundImage:{
        "front": "url('src/assets/myblue.jpg')"
      },
      maxWidth: {
        "primary": "1140px",
        "secondary": "786px",
        "third": "1240px"
      }
    },
  },
  plugins: [],
}

