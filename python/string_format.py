def transform(only_names):
    if len(only_names) == 1:
        return only_names[0]
    elif len(only_names) == 2:
        return '{} & {}'.format(only_names[0], only_names[1])
    else:
        return '{} & {}'.format(', '.join(only_names[0:-1]), only_names[-1])

def namelist(names):
    if len(names) == 0:
        return ''
    else:
        only_names = list(map(lambda name: name['name'], names))
        result = transform(only_names)
        return result