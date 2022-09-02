const interestRate = {
  2: {
    minimum: 1,
    maximum: 30,
  },
  2.2: {
    minimum: 31,
    maximum: 60,
  },
  2.4: {
    minimum: 61,
    maximum: 90,
  },
  2.6: {
    minimum: 91,
    maximum: 120,
  },
  2.8: {
    minimum: 121,
    maximum: 180,
  },
  3: {
    minimum: 181,
    maximum: 240,
  },
  3.2: {
    minimum: 241,
    maximum: 300,
  },
  3.4: {
    minimum: 301,
    maximum: 360,
  },
};

const calcTableValues = (interestKey, ammount) => {
  const term = interestRate[interestKey].maximum;
  const interest = Number(interestKey).toFixed(2);
  const gain = (ammount * (((interest / 100) * term) / 360)).toFixed(2);

  return {
    term,
    interest,
    gain,
  };
};

const investmentSimulator = (ammount, term) => {
  let table = {};

  if (!term) {
    table = Object.keys(interestRate).map((interestKey) => {
      const { term, interest, gain } = calcTableValues(interestKey, ammount);
      return {
        term,
        interest: `${interest}%`,
        gain: `\$${gain}`,
        total: `\$${Number(ammount + gain).toFixed(2)}`,
      };
    });
    return table;
  }
};

module.exports = {
  investmentSimulator,
};
