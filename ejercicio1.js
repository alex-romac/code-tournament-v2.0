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

const calcTableValues = (interestKey, ammount, termino) => {
  const term = termino ? termino : interestRate[interestKey].maximum;
  const interest = Number(interestKey).toFixed(2);
  const gain = (ammount * (((interest / 100) * term) / 360)).toFixed(2);

  return {
    term,
    interest,
    gain,
  };
};

const investmentSimulator = (ammount, termino) => {
  let table = {};

  if (!termino) {
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

  if (termino > 0 && termino <= 360) {
    console.log(termino);
    const interestKey = Object.keys(interestRate).filter((key) => {
      return (
        termino <= interestRate[key].maximum &&
        termino > interestRate[key].minimum
      );
    })[0];
    const { term, interest, gain } = calcTableValues(
      interestKey,
      ammount,
      Number(termino)
    );
    return {
      term,
      interest: `${interest}%`,
      gain: `\$${gain}`,
      total: `\$${Number(ammount + gain).toFixed(2)}`,
    };
  }
};

module.exports = {
  investmentSimulator,
};
