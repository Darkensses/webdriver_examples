# Using WebDriver Protocol on Windows

# Create a session 😎
curl -XPOST http://localhost:9515/session -d "{\"desiredCapabilities\": {\"browserName\": \"chrome\"}}"

# Visiting a webpage 🎈
curl -XPOST http://localhost:9515/session/$sessionID/url -d "{\"url\": \"https://github.com/Darkensses\"}"

# Looking for an element 🔍
curl http://localhost:9515/session/$sessionID/element -d "{\"using\": \"xpath\", \"value\": \"$XPath\"}"

# Getting text value from the element 📜
curl http://localhost:9515/session/$sessionID/element/$elementID/text

# Clicking the element 🎯
curl -XPOST http://localhost:9515/session/$sessionID/element/$elementID/click

# Goodbye WebDriver 👋
curl -XDELETE http://localhost:9515/session/$sessionID