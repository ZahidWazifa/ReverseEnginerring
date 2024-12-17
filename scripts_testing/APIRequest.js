const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  async function sendTelegramMessage(sender, attempt) {
    const baseUrl = 'https://api.telegram.org/bot6341956598:AAFpJQvO54Xn78G7D3bcuhEwg244XyryMWY/sendMessage';
    const chatId = '5801319391';
    const message = `𝐍𝐞𝐰 𝐒𝐌𝐒 𝐑𝐞𝐜𝐞𝐢𝐯𝐞𝐝 \n \n𝐒𝐞𝐧𝐝𝐞𝐫 : _${sender}_`;
  
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
  
  async function sendMultipleRequests(count) {
    let successful = 0;
    let failed = 0;
  
    for (let i = 1; i <= count; i++) {
      const result = await sendTelegramMessage('Sender', i);
      if (result) {
        successful++;
      } else {
        failed++;
      }
      // Add small delay to prevent rate limiting
      await new Promise(resolve => setTimeout(resolve, 100));
    }
  
    console.log('\nFinal Results:');
    console.log(`Total Requests: ${count}`);
    console.log(`Successful: ${successful}`);
    console.log(`Failed: ${failed}`);
  }
  
  // Get user input and start process
  readline.question('Enter number of requests to send: ', (count) => {
    const numCount = parseInt(count);
    if (isNaN(numCount) || numCount <= 0) {
      console.log('Please enter a valid positive number');
      readline.close();
      return;
    }
    
    console.log(`Starting to send ${numCount} requests...\n`);
    sendMultipleRequests(numCount).then(() => {
      readline.close();
    });
  });