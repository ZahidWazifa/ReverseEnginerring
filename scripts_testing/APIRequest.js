const delay = ms => new Promise(resolve => setTimeout(resolve, ms));

async function sendTelegramMessage(attempt) {
  const baseUrl = 'https://api.telegram.org/bot6341956598:AAFpJQvO54Xn78G7D3bcuhEwg244XyryMWY/sendMessage';
  const chatId = '5801319391';
  const message = `Test message #${attempt}`;

  try {
    const url = `${baseUrl}?parse_mode=markdown&chat_id=${chatId}&text=${encodeURIComponent(message)}`;
    const response = await fetch(url);
    
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    
    console.log(`Request ${attempt}: Success`);
    return true;
  } catch (error) {
    console.log(`Request ${attempt}: Failed - ${error.message}`);
    return false;
  }
}

async function sendInfiniteRequests() {
  let attempt = 1;
  console.log('Starting infinite requests. Press Ctrl+C to stop...\n');

  process.on('SIGINT', () => {
    console.log(`\nStopped after ${attempt - 1} requests`);
    process.exit();
  });

  while (true) {
    try {
      await sendTelegramMessage(attempt);
      attempt++;
      await delay(1000); // 1 second delay between requests
    } catch (error) {
      console.error(`Error in request #${attempt}:`, error.message);
      await delay(5000); // 5 seconds delay on error
    }
  }
}

// Start the infinite requests
sendInfiniteRequests();
